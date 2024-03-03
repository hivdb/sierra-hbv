#! /usr/bin/env python3
import re
import sys
import csv
import json

from typing import Dict, List, Any, Optional

DRUG_NAMES: Dict[str, str] = {
    '3TC': 'LMV'
}


def parseCondition(row: Dict[str, str]) -> Dict[str, Any]:
    cond_type = row['conditionType']
    cond_text = row['condition']
    if cond_type == 'MUTATION':
        conds: List[Dict[str, Any]] = []
        for mut in cond_text.split(' OR '):
            m: Optional[re.Match] = re.match(r'^(\d+)([^\d]+)$', mut)
            if not m:
                raise RuntimeError('invalid mutation {}'.format(mut))
            conds.append({
                'gene': row['gene'],
                'pos': int(m.group(1)),
                'aas': m.group(2).replace('i', '_').replace('d', '-')
            })
        if len(conds) == 1:
            return conds[0]
        else:
            return {'or': conds}
    else:  # if cond_type == 'DRUGLEVEL':
        conds = []
        for druglevel in cond_text.split(' AND '):
            drug, level = druglevel.split('=', 1)
            conds.append({
                'drug': DRUG_NAMES.get(drug, drug),
                'levels': [level]
            })
        if len(conds) == 1:
            return conds[0]
        else:
            return {'and': conds}


def main() -> None:
    input_csv = open(sys.argv[1], 'r', encoding='utf-8-sig')
    output_json = sys.stdout
    reader: csv.DictReader = csv.DictReader(input_csv)
    cmtlist = []
    for row in reader:
        cmtlist.append({
            'strain': 'HBV',
            'commentName': row['id'],
            'drugClass': row['drugClass'],
            'conditionType': row['conditionType'],
            'conditionValue': parseCondition(row),
            'comment': row['text']
        })
    json.dump(cmtlist, output_json, indent=2)


if __name__ == '__main__':
    main()

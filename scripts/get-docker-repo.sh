#! /bin/bash

BRANCH=`git rev-parse --abbrev-ref HEAD`

if [[ "$BRANCH" == "main" ]]; then
    echo "hivdb/sierra-ebv"
else
    echo "hivdb/sierra-ebv-testing"
fi

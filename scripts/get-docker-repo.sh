#! /bin/bash

BRANCH=`git rev-parse --abbrev-ref HEAD`

if [[ "$BRANCH" == "main" ]]; then
    echo "hivdb/sierra-hbv"
else
    echo "hivdb/sierra-hbv-testing"
fi

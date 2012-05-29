#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

function current_dir {
  echo "$(cd "$(dirname $0)"; pwd)"
}


#!/usr/bin/env bash
# script converts txt files to properties files
cd res

for file in *.txt
do
    native2ascii $file > "`basename $file .txt`.properties"
done
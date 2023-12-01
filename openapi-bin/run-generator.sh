#! /bin/bash
@echo off
java -jar openapi-generator-cli.jar generate -i specs.yaml -c configs.json -g spring -o ../
echo Open api generator has been executed!
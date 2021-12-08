#!/usr/bin/env bash

find src/ -type f -name '*.java' | xargs /usr/bin/env javac -d bin

/usr/bin/env java -cp bin figury/AnimatorApp $@


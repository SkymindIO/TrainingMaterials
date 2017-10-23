#!/bin/sh

# sudo visudo
# comment out: Defaults    always_set_home
# add: Defaults env_keep += "HOME"

scl enable devtoolset-4 bash
export PATH=/usr/bin:$PATH 

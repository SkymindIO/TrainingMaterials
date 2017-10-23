#!/bin/bash

# environment variables per anaconda and package dependencies
# export PATH=${HOME}/openmpi/bin:$PATH
# export LD_LIBRARY_PATH=${HOME}/openmpi/lib:$LD_LIBRARY_PATH

# open-mpi (distribution specific)
export PATH=/usr/lib64/openmpi/bin:$PATH
export LD_LIBRARY_PATH=/usr/lib64/openmpi/lib:$LD_LIBRARY_PATH
# required for cntk
export ANACONDA3_PATH=${INSTALL_DEST_DIR}/anaconda3
export PATH=${ANACONDA3_PATH}/bin:$PATH

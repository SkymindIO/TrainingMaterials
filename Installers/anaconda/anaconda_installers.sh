#!/bin/sh

anaconda_install=true
cntk_install=false
distribution="centos"
cmd_install="yum"

if [ "$distribution" == "ubuntu" ]; then
    # distibution dependencies
    ${cmd_install} install -y python-software-properties
    ${cmd_install} install -y python-dev python-pip python-wheel
    ${cmd_install} install -y python3-dev python3-pip python3-wheel
    ${cmd_install} upgrade -y python-setuptools
    ${cmd_install} install -y daemontools
    ${cmd_install} install -y graphviz
    ${cmd_install} install -y openmpi-bin
    ${cmd_install} install -y tmux
else
    # change to python 3 (manually)
    ${cmd_install} -y groupinstall development
    ${cmd_install} -y update
    ${cmd_install} install -y openmpi
    ${cmd_install} install -y tmux
    ${cmd_install} install -y graphviz
    ${cmd_install} install -y libpng12
    pip install easybuild
fi
 

# cntk installer
if [[ $cntk_install = true ]]; then
    cntk_dst=$HOME
    wget https://cntk.ai/BinaryDrop/CNTK-2-2-Linux-64bit-GPU.tar.gz \
        && tar -xzvf CNTK-2-2-Linux-64bit-GPU.tar.gz -C $cntk_dst   \
        && ${HOME}/cntk/Scripts/install/linux/install-cntk.sh       \
        && rm CNTK-2-2-Linux-64bit-GPU.tar.gz

# vanilla anaconda3 install
else
    if [[ $anaconda_install = true ]]; then
        wget https://repo.continuum.io/archive/Anaconda3-4.4.0-Linux-x86_64.sh \
            && bash Anaconda3-4.4.0-Linux-x86_64.sh -b -p ${ANACONDA3_PATH}    \
            && conda update  -y anaconda \
            && conda upgrade -y conda    \
            && conda update  -y setuptools \
            && rm Anaconda3-4.4.0-Linux-x86_64.sh \
            && conda clean -yt
    fi
fi

# update root environment pip
pip install --upgrade pip

# create the specific environment
CONFIG_DIR=$HOME/Installers/anaconda/config
anaconda_envs=(skymind.ml.dl.cpu)
for src_env in "${anaconda_envs[@]}"; do
    conda env create -f ${CONFIG_DIR}/${src_env}_envs.yml
    # activate the root environment
    PATH=${ANACONDA3_PATH}/envs/${default_env}/bin:$PATH
    source activate ${src_env}
    # activate additional extensions for each installation
    conda update -y setuptools
    jupyter contrib nbextension install --user
    # reset back to default environment
    source activate root
done

# change permission paths
USER_PERM=`echo $(logname)`
chown -R ${USER_PERM}:${USER_PERM} ${ANACONDA3_PATH}
# setup default profile: code changes take effect without reload
cp -avf $HOME/Installers/anaconda/startup/autoreload_startup.ipy $HOME/.ipython/profile_default/startup/

# list install environments
conda env list




 











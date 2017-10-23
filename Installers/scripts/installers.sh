#!/bin/sh

export INSTALL_DEST_DIR=/mnt/skymind/depot

# start from scrach
rm -rf $INSTALL_DEST_DIR
mkdir -p $INSTALL_DEST_DIR

# run individual intallers
source $HOME/Installers/anaconda/anaconda_dot.sh
$HOME/Installers/anaconda/anaconda_installers.sh
$HOME/Installers/spark/spark_installers.sh

# copy dot files
mkdir $INSTALL_DEST_DIR/dots
cp -avf $HOME/Installers/anaconda/anaconda_dot.sh $INSTALL_DEST_DIR/dots/anaconda.sh
cp -avf $HOME/Installers/spark/spark_dot.sh $INSTALL_DEST_DIR/dots/spark.sh
cp -avf $HOME/Installers/vim/vimrc.sh $INSTALL_DEST_DIR/dots/vimrc.sh

# change permission paths
USER_PERM=`echo $(logname)`
chown -R ${USER_PERM}:${USER_PERM} ${INSTALL_DEST_DIR/dots}


# make symbolic links if not existent
if [[ ! -L $HOME/.vimrc ]]; then
    ln -s $INSTALL_DEST_DIR/dots/vimrc.sh $HOME/.vimrc
fi

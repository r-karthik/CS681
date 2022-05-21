package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendChild(this);
        }

    }

    @Override
    public boolean isDirectory() {
        try {
            if(this instanceof Directory) {
                return true;
            }
            return false;
        }
        finally {
            lock.unlock();
        }
    }

    LinkedList<FSElement> children = new LinkedList<FSElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();

    public LinkedList<FSElement> getChildren(){
        lock.lock();
        try{
            return this.children;
        }
        finally {
            lock.unlock();
        }
    }

    public void appendChild(FSElement child ){
        lock.lock();
        try {
            this.children.add(child);
        }
        finally {
            lock.unlock();
        }
    }


    public int countChildren(){
        lock.lock();
        try {
            int countChildren = 0;
            for (FSElement f : this.children)
                countChildren += 1;
            return countChildren;
        } finally {
            lock.unlock();
        }
    }



    public LinkedList<Directory> getSubDirectories(){
        lock.lock();
        try {
            LinkedList<Directory> directories = new LinkedList<>();
            for (FSElement fsElement : children) {
                if (fsElement instanceof Directory)
                    directories.add((Directory) fsElement);
            }
            return directories;
        } finally {
            lock.unlock();
        }
    }


    public LinkedList<File> getFiles(){
        lock.lock();
        try {

            for (FSElement fsElement : children) {
                if (fsElement instanceof File)
                    file.add((File) fsElement);
            }
            return file;
        } finally {
            lock.unlock();
        }
    }

    public int getTotalSize(){
        lock.lock();
        try{
            FSElement dir= this;
            Directory d=(Directory) dir;
            int i;
            int z=0;
            for(i=0;i<d.getChildren().size();i++){
                z=z+d.getChildren().get(i).getSize();
            }
            return z;
        }
        finally{
            lock.unlock();
        }


    }

}


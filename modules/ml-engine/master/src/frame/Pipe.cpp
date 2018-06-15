
#include "Pipe.h"


int Pipe::writePipe(char *buf) {
    return write(fd_[1], buf, sizeof(buf));
}

int Pipe::writePipe() {
    return write(fd_[1], buffer, read_size);
    //return write(fd_[0], buffer, sizeof(buffer));
}

int Pipe::readPipe() {
    return read(fd_[0], buffer, read_size);
}

int Pipe::getWriteFD() {
    return fd_[1];
}

int Pipe::getReadFD() {
    return fd_[0];
}

char* Pipe::getBuffer() {
    return buffer;
}

/* end of load_pipe.c */

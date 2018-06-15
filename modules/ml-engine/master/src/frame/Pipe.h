/**
 * @file    load_pipe.h
 * @brief   TODO brief documentation here.
 *
 * @author
 * @version $Id$
 */

#ifndef _LOAD_PIPE_H
#define _LOAD_PIPE_H

#ifdef _WIN32
#include <mingw.thread.h>
#include <fcntl.h>
#else
#include <unistd.h>
#endif

#include "Event.h"

class Pipe {
public:
    Pipe() {
        Pipe::pipeSyscall(fd_);
    }

    ~Pipe() {
        close(fd_[0]);
        close(fd_[1]);
    }

    int writePipe();
    int writePipe(char *);
    int readPipe();
    int getWriteFD();
    int getReadFD();
    char* getBuffer();

private:
    const static int read_size = 32;
    int fd_[2];
    char buffer[32];
    static int pipeSyscall(int *fds) {
#ifdef _WIN32
        return _pipe(fds, 4096, _O_BINARY);
#else
        return pipe(fds);
#endif
    }

};


#endif /* no _LOAD_PIPE_H */

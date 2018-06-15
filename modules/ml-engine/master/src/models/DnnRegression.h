/**
 * Project Untitled
 */


#ifndef _DNNREGRESSION_H
#define _DNNREGRESSION_H

#include "BaseAlgorithm.h"


class DnnRegression: public BaseAlgorithm {
public: 
	string* featureColumList;
	int* hiddenUnitSize;
};

#endif //_DNNREGRESSION_H
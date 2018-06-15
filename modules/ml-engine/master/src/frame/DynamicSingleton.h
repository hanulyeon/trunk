/*
 * DynamicSingleton.h
 *
 *  Created on: Apr 8, 2018
 *      Author: tmax
 */

#ifndef DYNAMICSINGLETON_H_
#define DYNAMICSINGLETON_H_

template < typename T >
class DynamicSingleton
{
protected:
	DynamicSingleton()
    {

    }
    virtual ~DynamicSingleton()
    {

    }

public:
    static T * getInstance()
    {
        if (m_pInstance == nullptr)
            m_pInstance = new T;
        return m_pInstance;
    };

    static void destroyInstance()
    {
        if (m_pInstance)
        {
            delete m_pInstance;
            m_pInstance = nullptr;
        }
    };

private:
    static T * m_pInstance;
};

template <typename T> T * DynamicSingleton<T>::m_pInstance = 0;


#endif /* DYNAMICSINGLETON_H_ */

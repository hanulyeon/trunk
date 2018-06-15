/*
 * race_test.cpp
 *
 *  Created on: Jun 5, 2018
 *      Author: tmax
 */

#include <iostream>
#include <thread>
#include <mutex>
#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;
void CallHome(string message, int val);
void CallHome(string message, int val)
{
  int a = 0;
  while(a != val)
  {
	  cout << "Thread " << this_thread::get_id() << message << a <<endl;
	  a++;
  }
}
int main() {
	cout << "Race Test" << endl;

	thread t1(CallHome, "Jupiter", 1000);
	thread t2(CallHome, "Pluto", 3000);
	thread t3(CallHome, "Moon", 2000);

	while(true)
	{
		;
	}

	return 0;
}

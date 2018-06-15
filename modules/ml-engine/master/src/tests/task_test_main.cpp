///*
// * task_test_main.cpp
// *
// *  Created on: Apr 3, 2018
// *      Author: tmax
// */
//
//
//#include "../tasks/TrainingStartTask.cpp"
//
//#include <iostream>
//#include <string>
//#include <memory>
//#include <deque>
//
//using namespace std;
//
//int main(){
//
//	cout << "ml-enine-master task test..." << endl;
//
//	TrainingStartTask task;
//
//    EventAlpha eva(777432);
//    std::unique_ptr<RawSendable> msgAlpha(new RawSendable(EVENT_ALPHA, eva.marshal()));
//    task.handle(std::move(msgAlpha));
//
//    EventBeta evb(-23341);
//    std::unique_ptr<RawSendable> msgBeta(new RawSendable(EVENT_BETA, evb.marshal()));
//    task.handle(std::move(msgBeta));
//
//    LockOwnershipChange evl;
//    std::unique_ptr<RawSendable> msgLock(new RawSendable(LOCK_IS_YOURS, evl.marshal()));
//    task.handle(std::move(msgLock));
//
//    std::deque<std::pair<std::string, int>> expected{{"alpha", 777432}, {"beta", -23341}, {"lock", 1}};
//
//	cout << "ml-enine-master task done..." << endl;
//	return 1;
//}

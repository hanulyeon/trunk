#include "../EventManager.h"
#include "../InputDataManager.h"
#include "../ResourceManager.h"
#include "../ScriptBuilder.h"
#include "../JobManager.h"
#include "../models/MetaData.h"

#include <iostream>
#include <string>

using namespace std;
int main(){

	cout << "ml-enine-master test..." << endl;

	JobManager* jobManager = new JobManager();
	InputDataManager* inputDataManager = new InputDataManager();
	ResourceManager* resourceManager = new ResourceManager();
	ScriptBuilder* scriptBuilder = new ScriptBuilder();
	cout << "managers are ready..." << endl;

	Job* job_1 = new Job(8, 10000, 234);
	Job* job_2 = new Job(9, 20000, 389);
	Job* job_3 = new Job(10, 25000, 888);
	cout << "jobs are created..." << endl;


	cout << "building script..." << endl;
	string script_1 = scriptBuilder->build("Leaning Code 1");
	string script_2 = scriptBuilder->build("Leaning Code 2");
	string script_3 = scriptBuilder->build("Leaning Code 3");
//
//	jobManager->dispatch(job_1, script_1);
//	jobManager->dispatch(job_2, script_2);
//	jobManager->dispatch(job_3, script_3);
	cout << "jobs are dispatched..." << endl;

	jobManager->showJobList();

	inputDataManager->assignJob(job_1->getId());
	inputDataManager->assignJob(job_2->getId());
	inputDataManager->assignJob(job_3->getId());
	cout << "jobs are assigned to InputDataManager..." << endl;


	MetaData* meta_1 = new MetaData("//192.1.1.200","meta_1");
	MetaData* meta_2 = new MetaData("//192.1.1.200","meta_2");
	MetaData* meta_3 = new MetaData("//192.1.1.100","meta_3");
	MetaData* meta_4 = new MetaData("//192.1.1.100","meta_4");
	MetaData* meta_5 = new MetaData("//192.1.1.88","meta_5");
	MetaData* meta_6 = new MetaData("//192.1.1.88","meta_6");
	cout << "incoming MetaData..." << endl;

	inputDataManager->putMetaDataWithJobId(job_1->getId(), meta_1);
	inputDataManager->putMetaDataWithJobId(job_1->getId(), meta_2);
	inputDataManager->putMetaDataWithJobId(job_2->getId(), meta_3);
	inputDataManager->putMetaDataWithJobId(job_2->getId(), meta_4);
	inputDataManager->putMetaDataWithJobId(job_3->getId(), meta_5);
	inputDataManager->putMetaDataWithJobId(job_3->getId(), meta_6);
	cout << "stored MetaData..." << endl;

	cout << "origin: " << meta_1->fileLocation << " ," << meta_1->fileName << endl;
	cout << "origin: " << meta_2->fileLocation << " ," << meta_2->fileName << endl;
	MetaData* test_1 = inputDataManager->getMetaDataWithJobId(job_1->getId(), true);
	MetaData* test_2 = inputDataManager->getMetaDataWithJobId(job_1->getId(), true);
	cout << "test_1: " << test_1->fileLocation << " ," << test_1->fileName << endl;
	cout << "test_2: " << test_2->fileLocation << " ," << test_2->fileName << endl;

	cout << "origin: " << meta_3->fileLocation << " ," << meta_3->fileName << endl;
	cout << "origin: " << meta_4->fileLocation << " ," << meta_4->fileName << endl;
	MetaData* test_3 = inputDataManager->getMetaDataWithJobId(job_2->getId(), true);
	MetaData* test_4 = inputDataManager->getMetaDataWithJobId(job_2->getId(), true);
	cout << "test_3: " << test_3->fileLocation << " ," << test_3->fileName << endl;
	cout << "test_4: " << test_4->fileLocation << " ," << test_4->fileName << endl;


	cout << "origin: " << meta_5->fileLocation << " ," << meta_5->fileName << endl;
	cout << "origin: " << meta_6->fileLocation << " ," << meta_6->fileName << endl;
	MetaData* test_5 = inputDataManager->getMetaDataWithJobId(job_3->getId(), true);
	MetaData* test_6 = inputDataManager->getMetaDataWithJobId(job_3->getId(), true);
	cout << "test_3: " << test_5->fileLocation << " ," << test_5->fileName << endl;
	cout << "test_4: " << test_6->fileLocation << " ," << test_6->fileName << endl;


	cout << "start finishing jobs..." << endl;
	jobManager->removeJob(job_1->getId());
	jobManager->removeJob(job_2->getId());
	jobManager->removeJob(job_3->getId());

	cout << "finished removing jobs in JobManager..." << endl;
	jobManager->showJobList();

	inputDataManager->removeJob(job_1->getId());
	inputDataManager->removeJob(job_2->getId());
	inputDataManager->removeJob(job_3->getId());
	cout << "finished removing jobs in InputDataManager..." << endl;

	cout << "all done...!" << endl;

	return 1;
}

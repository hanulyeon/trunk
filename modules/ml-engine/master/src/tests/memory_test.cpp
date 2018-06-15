#include <iostream>
#include <string>
#include <vector>
using namespace std;
class ResourceInfo
{
public:
	ResourceInfo(int owner) : owner(owner)  {}

	void addNode(string ip, int port)
	{
		IpPortPairVector.push_back(new IpPortPair(IpPortPairVector.size(), ip, port));
	}
	void cleanPop()
	{
		int i = 0;
		auto iter = std::begin(IpPortPairVector);

		IpPortPair* p[4];
		while (iter != std::end(IpPortPairVector))
		{
			cout << (*iter) << "port: "<< (*iter)->port << endl;
			p[i] = (*iter);
//			delete (*iter);
			IpPortPairVector.erase(iter);
			++i;
		}
		cout << "size: " << IpPortPairVector.size() << endl;

		for(i = 0 ; i < 4 ; i++)
		{
			cout << p[i]  << "port: "<< p[i]->port << endl;
		}
		IpPortPairVector.clear();

		cout << "after clear size: " << IpPortPairVector.size() << endl;

		for(i = 0 ; i < 4 ; i++)
		{
			cout << p[i]  << "port: "<< p[i]->port << endl;
		}

		delete p[0];
		delete p[1];
		delete p[2];
		delete p[3];
		cout << "after delete all objects: " << IpPortPairVector.size() << endl;
		for(i = 0 ; i < 4 ; i++)
		{
			cout << p[i]  << "port: "<< p[i]->port << endl;
		}
	}
	void clean()
	{
		int i = 0;
		IpPortPair* p[4];

		cout << "size: " << IpPortPairVector.size() << endl;

		auto iter = std::begin(IpPortPairVector);

		while (iter != std::end(IpPortPairVector))
		{
			cout << (*iter) << "port: "<< (*iter)->port << endl;
			p[i] = (*iter);
			++iter;
			++i;
		}
		IpPortPairVector.clear();

		cout << "after clear size: " << IpPortPairVector.size() << endl;

		for(i = 0 ; i < 4 ; i++)
		{
			cout << p[i]  << "port: "<< p[i]->port << endl;
		}

		delete p[0];
		delete p[1];
		delete p[2];
		delete p[3];

		cout << "after delete array size: " << IpPortPairVector.size() << endl;

		for(i = 0 ; i < 4 ; i++)
		{
			cout << p[i]  << "port: "<< p[i]->port << endl;
		}

		// 모든 요소마다 일일이 지워줘야 데이터삭제됨
	}
private:
	int owner;
	struct IpPortPair
	{
		int id;
		int port;
		string ip;
		IpPortPair(int id, string ip, int port) : id(id), ip(ip), port(port){}
	};
	vector<IpPortPair*> IpPortPairVector;

};

int main(){
	ResourceInfo* rs = new ResourceInfo(1);

	rs->addNode("test", 1);
	rs->addNode("test", 2);
	rs->addNode("test", 3);
	rs->addNode("test", 4);

	//	rs->clean();
	rs->cleanPop();
	return 0;
}

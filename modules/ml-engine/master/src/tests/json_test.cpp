/*
 * json_test.cpp
 *
 *  Created on: May 23, 2018
 *      Author: tmax
 */

#include "../utils/json/json.h"

#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

class Custom
{
public:
	Custom(Json::Value& target)
	{
		obj.copy(target);

		Json::StyledWriter writer;
		string str = writer.write(obj);
		std::cout << str << std::endl << std::endl;
	}
	void jsonCopy(Json::Value& target)
	{
		obj.copy(target);

		Json::StyledWriter writer;
		string str = writer.write(obj);
		std::cout << str << std::endl << std::endl;
	}
private:
	Json::Value obj;
};
int main() {
	cout << "Json Generate Test" << endl;

	std::string str;

	Json::Value root;
	root["id"] = "Luna";
	root["name"] = "Silver";
	root["age"] = 19;
	root["hasCar"] = false;

	Json::Value items;
	items.append("nootbook");
	items.append("ipadmini2");
	items.append("iphone5s");
	root["items"] = items;

	Json::Value friends;
	Json::Value tom;
	tom["name"] = "Tom";
	tom["age"] = 21;
	Json::Value jane;
	jane["name"] = "jane";
	jane["age"] = 23;
	friends.append(tom);
	friends.append(jane);
	root["friends"] = friends;

	Json::StyledWriter writer;
	str = writer.write(root);
	std::cout << str << std::endl << std::endl;


	cout << "Json Parsing Test" << endl;

	Json::Reader reader;
	Json::Value root2;
	bool parsingRet = reader.parse(str, root2);

	if (!parsingRet)
	{
		std::cout << "Failed to parse Json : " << reader.getFormattedErrorMessages();
		return 0;
	}

	std::cout << root2["hasCar"] << " : " << root2["age"] << std::endl << std::endl;

	const Json::Value items2 = root2["items"];
	for (int i = 0; i < items2.size(); i++)
	{
		std::cout << items2[i].asString() << std::endl;
	}
	std::cout << std::endl;

	auto member = root2.getMemberNames();

	for (std::string s : member)
	{
		std::cout << s << std::endl;
	}
	std::cout << std::endl;

	for (std::string s : member)
	{
		if (root2[s].isString())
		{
			std::cout << root[s] << std::endl;
		}
	}
	std::cout << std::endl;

	Json::Value friends2 = root2["friends"];
	for (auto it = friends2.begin(); it != friends2.end(); it++)
	{
		if (it->isObject())
		{
			std::cout << (*it)["name"] << " : " << (*it)["age"] << std::endl;
		}
	}
	std::cout << std::endl;


	std::cout << root2["asdasdasd"] << std::endl;
	std::cout << root2["asdasdasd"].isNull() << std::endl;

	Custom* custom = new Custom(root);
	root2["Difference"] = true;
	custom->jsonCopy(root2);

	Json::Value* val = new Json::Value();
	(*val)["id"] = "Luna";
	std::string sss = writer.write((*val));
	std::cout << sss << std::endl << std::endl;
	return 0;
}


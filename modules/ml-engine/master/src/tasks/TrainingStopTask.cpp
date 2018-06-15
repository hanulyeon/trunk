//
//#ifndef _TRAININGSTARTTASK_CPP
//#define _TRAININGSTARTTASK_CPP
///**
// * TrainingStartTask implementation
// */
//
//
//#include "../frame/Task.hpp"
//#include "../frame/Event.hpp"
//
//#include <memory>
//#include <deque>
//#include <string>
//
///*
// * TODO: add test case that check the pending Events sorting order (High priority event comes first)
// * TODO: let the task(receiver) manipulate priority of pending event and check them applied.(switches the ordering) (preferably at factory time?)
// * */
//
//class EventAlpha : public Event<EventAlpha> {
//public:
//    /* for sender */
//    EventAlpha(int val) : val(val) {}
//
//    /* for receiver*/
//    EventAlpha(const Bytes &serialized) : val(0) { this->unmarshal(serialized); }
//
//    static const EventTypeID EventID() { return EVENT_ALPHA; }
//
//    static EventAlpha* newEvent(RawSendable &msg){
//        return new EventAlpha(msg.serializedPayload);
//    }
//
//    template<class Archive>
//    void serialize(Archive & ar, const unsigned int version)
//    {
//        ar & boost::serialization::base_object<Event>(*this); /* this will serialize contents in Parent class (i.e. Event, only priority field for now.)*/
//        ar & val;
//    }
//
//    int val;
//};
//
//class EventBeta : public Event<EventBeta> {
//public:
//    /* for sender*/
//    EventBeta(int val) : val(val) {}
//
//    /* for receiver*/
//    EventBeta(const Bytes &serialized) : val(0) { this->unmarshal(serialized); }
//
//    static const EventTypeID EventID() { return EVENT_BETA; }
//
//    static EventBeta* newEvent(RawSendable &msg){
//        return new EventBeta(msg.serializedPayload);
//    }
//
//    template<class Archive>
//    void serialize(Archive & ar, const unsigned int version)
//    {
//        ar & boost::serialization::base_object<Event>(*this); /* this will serialize contents in Parent class (i.e. Event, only priority field for now.)*/
//        ar & val;
//    }
//
//    int val;
//};
//
//class TrainingStartTask : public Task {
//public:
//	TrainingStartTask() : alphaDone(false), betaDone(false), lockDone(false) {
//        useDefaultHandler<EventAlpha>(this);
//        useDefaultHandler<EventBeta>(this);
//        useDefaultHandler<LockOwnershipChange>(this);
//    }
//
//    void start() override {}
//
//    void handleEvent(EventAlpha &event){
//        /*event.val++;*/
//        executResult.push_back(std::make_pair(std::string("alpha"), event.val));
//        alphaDone = true;
//    }
//
//    void handleEvent(EventBeta &event){
//        /*event.val++;*/
//        executResult.push_back(std::make_pair(std::string("beta"), event.val));
//        betaDone = true;
//    }
//
//    void handleEvent(LockOwnershipChange &event){
//        executResult.push_back(std::make_pair(std::string("lock"), 1));
//        lockDone = true;
//    }
//
//    void handle(std::unique_ptr<RawSendable> msg) override {
//        Task::handle(std::move(msg));
//        if(alphaDone && betaDone && lockDone)
//            quit();
//    }
//
//public:
//    std::deque<std::pair<std::string, int>> executResult;
//
//private:
//    bool alphaDone;
//    bool betaDone;
//    bool lockDone;
//};
//
//
//
//#endif //_TRAININGSTARTTASK_CPP

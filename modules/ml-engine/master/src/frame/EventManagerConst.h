
#ifndef EVENT_MANAGER_CONST_H_
#define EVENT_MANAGER_CONST_H_

namespace EVENT_MANAGER_CONST
{
	enum
	{
		MAX_EPOLL_SIZE = 9999
	};

	namespace RESPONSE
	{
		const static char* TYPE		= "Response";
		const static char* SUCCESS	= "success";
		const static char* JOB_ID	= "job_id";
		const static char* MESSAGE	= "message";
	}
	namespace RESOURCE
	{
		const static char* TYPE		= "Resource";
		const static char* NODE_FD	= "node_fd";
		const static char* STATUS	= "status";
		const static char* INDEX	= "index";
		const static char* IP		= "ip";
		const static char* PORT		= "port";
	}
	namespace TASK
	{
		const static char* TYPE		= "Task";
		const static char* TASK_ID	= "task_id";
	}
	namespace MODEL
	{
		const static char* TYPE				= "Model";
		const static char* ALGORITHM_NAME	= "algorithm_name";
		const static char* STEP_SIZE		= "step_size";
		const static char* BATCH_SIZE		= "batch_size";
	}
	namespace CLUSTER_CONFIGURATION
	{
		const static char* TYPE				= "ClusterConfiguration";
		const static char* CLUSTER_SIZE		= "cluster_size";
		const static char* PS_NUMBER		= "ps_number";
		const static char* WORKER_NUMBER	= "worker_number";
		const static char* IS_SYNCHRONOUS	= "is_synchronous";
	}
	namespace TRAINING
	{
		const static char* TYPE		= "Training";
		const static char* SCRIPT	= "script";
		const static char* JOB_ID	= "job_id";
		const static char* PS		= "ps";
		const static char* WORKER	= "worker";
	}
	namespace PROCESS
	{
		const static char* TYPE		= "Process";
		const static char* JOB_NAME	= "job_name";
		const static char* INDEX	= "index";
		const static char* IP		= "ip";
		const static char* PORT		= "port";
	}
}

#endif /* EVENT_H_ */

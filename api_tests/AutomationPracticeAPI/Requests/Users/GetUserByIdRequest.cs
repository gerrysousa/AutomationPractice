using AutomationPracticeAPI.Bases;
using AutomationPracticeAPI.Objects;
using RestSharp;

namespace AutomationPracticeAPI.Requests.Users
{
    class GetUserByIdRequest : RequestBase
    {
        public GetUserByIdRequest(int userId)
        {
            requestService = "/users/{userId }";
            method = Method.GET;

            parameters.Add("userId ", userId.ToString());

        }
    }
}
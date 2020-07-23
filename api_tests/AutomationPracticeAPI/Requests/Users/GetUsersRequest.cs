using AutomationPracticeAPI.Bases;
using AutomationPracticeAPI.Objects;
using RestSharp;

namespace AutomationPracticeAPI.Requests.Users
{
    class GetUsersRequest : RequestBase
    {
        public GetUsersRequest()
        {
            requestService = "/users";
            method = Method.GET;
        }
    }
}
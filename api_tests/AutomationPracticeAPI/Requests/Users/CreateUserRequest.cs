using AutomationPracticeAPI.Bases;
using AutomationPracticeAPI.Objects;
using RestSharp;


namespace AutomationPracticeAPI.Requests.Users
{
    class CreateUserRequest : RequestBase
    {
        public CreateUserRequest()
        {
            requestService = "/users";
            method = Method.POST;
        }

        public void SetJsonBody(User user)
        {
            Helpers.JsonSerializer aux = new Helpers.JsonSerializer();
            jsonBody = aux.Serialize(user);
        }
    }
}

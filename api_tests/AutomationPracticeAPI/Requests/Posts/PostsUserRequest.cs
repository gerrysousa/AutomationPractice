using AutomationPracticeAPI.Bases;
using AutomationPracticeAPI.Objects;
using RestSharp;

namespace AutomationPracticeAPI.Requests.Posts
{
    class PostsUserRequest : RequestBase
    {
        public PostsUserRequest()
        {
            requestService = "/posts";
            method = Method.POST;
        }

        public void SetJsonBody(Post project)
        {
            Helpers.JsonSerializer aux = new Helpers.JsonSerializer();
            jsonBody = aux.Serialize(project);
        }
    }
}
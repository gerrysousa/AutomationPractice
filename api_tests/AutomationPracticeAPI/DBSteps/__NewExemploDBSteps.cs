using RestSharp;
using AutomationPracticeAPI.Requests.__ExampleProjects;
using System;

namespace AutomationPracticeAPI.Tests
{
    public class FindPetSteps
    {

        public static string BuscarPetPorID(int petId)
        {
            __ExampleGetProjectsRequest findPetRequest = new __ExampleGetProjectsRequest(petId);
            IRestResponse<dynamic> response = findPetRequest.ExecuteRequest();
            if (!response.StatusCode.ToString().Equals("OK")){throw new Exception("Erro ao executar a requisição.");}
            return response.Data["name"].ToString();
        }
    }
}

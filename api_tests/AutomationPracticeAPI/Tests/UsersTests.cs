using NUnit.Framework;
using RestSharp;
using AutomationPracticeAPI.Bases;
using AutomationPracticeAPI.Requests.__ExampleProjects;
using System;
using System.Collections.Generic;
using System.Text;
using AutomationPracticeAPI.Helpers;
using System.Collections;
using AutomationPracticeAPI.DBSteps;
using AutomationPracticeAPI.Requests.Users;
using AutomationPracticeAPI.Objects;

namespace AutomationPracticeAPI.Tests
{
    [TestFixture]
    public class UsersTests : TestBase
    {
        /* [Test]
         public void Test_CadastrarProblemaMinimoInformacoesComSucesso()
         {
             #region Arrange
             CreateAnIssueRequest createAnIssueRequest = new CreateAnIssueRequest();
             Issue issue = new Issue();
             Category category = new Category();
             Project project = new Project();

             string statusEsperado = "Created";//201

             string summary = "This is a test issue";
             string description = "This is a test description";
             string categoryName = "General";
             string projectName = "Project 03 Update";
             #endregion

             #region acts
             category.name = categoryName;
             project.name = projectName;

             issue.summary = summary;
             issue.description = description;
             issue.category = category;
             issue.project = project;

             createAnIssueRequest.SetJsonBody(issue);

             IRestResponse<dynamic> response = createAnIssueRequest.ExecuteRequest();
             #endregion

             #region Asserts

             Assert.Multiple(() =>
             {
                 Assert.AreEqual(statusEsperado, response.StatusCode.ToString());
                 Assert.AreEqual(summary, response.Data.issue.summary.ToString());
                 Assert.AreEqual(description, response.Data.issue.description.ToString());

                 Assert.AreEqual(categoryName, response.Data.issue.category.name.ToString());
                 Assert.AreEqual(projectName, response.Data.issue.project.name.ToString());
                 //Etc
             });

             #endregion
         }
        */
        [Test]
        public void Test_GetAllUsers()
        {
            #region Arrange
            string expectedStatusCode = "OK";

            string name1 = "Leanne Graham";
            string username1 = "Bret";
            string email1 = "Sincere@april.biz";

            string name2 = "Ervin Howell";
            string username2 = "Antonette";
            string email2 = "Shanna@melissa.tv";

            #endregion

            #region acts
            GetUsersRequest getUsersRequest = new GetUsersRequest();
            IRestResponse<dynamic> response = getUsersRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());

                Assert.AreEqual(name1, response.Data[0].name.ToString());
                Assert.AreEqual(username1, response.Data[0].username.ToString());
                Assert.AreEqual(email1, response.Data[0].email.ToString());

                Assert.AreEqual(name2, response.Data[1].name.ToString());
                Assert.AreEqual(username2, response.Data[1].username.ToString());
                Assert.AreEqual(email2, response.Data[1].email.ToString());
                //Etc
            });

            #endregion
        }

        [Test]
        public void Test_GetUsersByID()
        {
            #region Arrange
            string expectedStatusCode = "OK";
            int userId = 3;
            string name1 = "Clementine Bauch";
            string username1 = "Samantha";
            string email1 = "Nathan@yesenia.net";

            #endregion

            #region acts
            GetUserByIdRequest getUsersRequest = new GetUserByIdRequest(userId);
            IRestResponse<dynamic> response = getUsersRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.AreEqual(name1, response.Data.name.ToString());
                Assert.AreEqual(username1, response.Data.username.ToString());
                Assert.AreEqual(email1, response.Data.email.ToString());
                //Etc
            });

            #endregion
        }


        [Test]
        public void Test_CreateAnUser()
        {
            #region Arrange
            string expectedStatusCode = "Created";
            string name = "User Teste";
            string username = "teste122";
            string email = "teste122@teste.net";

            User user = new User();
            user.name = name;
            user.username = username;
            user.email = email;
            #endregion


            #region acts
            CreateUserRequest createUserRequest = new CreateUserRequest();
            createUserRequest.SetJsonBody(user);
            IRestResponse<dynamic> response = createUserRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.AreEqual(name, response.Data.name.ToString());
                Assert.AreEqual(username, response.Data.username.ToString());
                Assert.AreEqual(email, response.Data.email.ToString());
                //Etc
            });

            #endregion
        }

        [Test]
        public void Test_CreateAnUserInvalidEmail()
        {
            #region Arrange
            string expectedStatusCode = "Created";
            string name = "User Teste";
            string username = "teste122";
            string email = "teste122@teste.net";

            User user = new User();
            user.name = name;
            user.username = username;
            user.email = email;
            #endregion


            #region acts
            CreateUserRequest createUserRequest = new CreateUserRequest();
            createUserRequest.SetJsonBody(user);
            IRestResponse<dynamic> response = createUserRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.AreEqual(name, response.Data.name.ToString());
                Assert.AreEqual(username, response.Data.username.ToString());
                Assert.AreEqual(email, response.Data.email.ToString());
                //Etc
            });

            #endregion
        }


        [Test]
        public void Test_ValidEmailSuccess()
        {
            #region Arrange
            string expectedStatusCode = "OK";
            int userId = 3;

            #endregion

            #region acts
            GetUserByIdRequest getUsersRequest = new GetUserByIdRequest(userId);
            IRestResponse<dynamic> response = getUsersRequest.ExecuteRequest();
            string emailResponse = response.Data.email.ToString();
            #endregion

            #region Asserts

            bool isValidEmail = RegexHelpers.IsValidEmail(emailResponse);
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.True(isValidEmail);
                //Etc
            });

            #endregion
        }

        [Test]
        public void Test_ValidCompanyName()
        {
            #region Arrange
            string expectedStatusCode = "OK";
            int userId = 3;
            bool catchPhraseLess50=true;

            #endregion

            #region acts
            GetUserByIdRequest getUsersRequest = new GetUserByIdRequest(userId);
            IRestResponse<dynamic> response = getUsersRequest.ExecuteRequest();
            string companyCatchPhrase = response.Data.company.catchPhrase.ToString();
            #endregion

            #region Asserts
            if (companyCatchPhrase.Length > 50)
            {
                catchPhraseLess50 = false;
            }
            
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.True(catchPhraseLess50);
                //Etc
            });
            #endregion
        }
    }
}
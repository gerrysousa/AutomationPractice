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
using AutomationPracticeAPI.Requests.Posts;

namespace AutomationPracticeAPI.Tests
{
    [TestFixture]
    class PostsTests : TestBase
    {

        [Test]
        public void Test_CreatePostSuccess()
        {
            #region Arrange
            string expectedStatusCode = "Created";
            int userId = 3;
            string title = "post testes";
            string body = "body body body body ";

            Post post = new Post();
            post.body = body;
            post.userId = userId;
            post.title = title;
            #endregion


            #region acts
            PostsUserRequest postsUserRequest = new PostsUserRequest();
            postsUserRequest.SetJsonBody(post);
            IRestResponse<dynamic> response = postsUserRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                Assert.AreEqual(userId.ToString(), response.Data.userId.ToString());
                Assert.AreEqual(title, response.Data.title.ToString());
                Assert.AreEqual(body, response.Data.body.ToString());
                //Etc
            });

            #endregion
        }

        [Test]
        public void Test_CreatePostWithoutTitle()
        {
            #region Arrange
            string expectedStatusCode = "BadRequest";
            int userId = 3;
            string body = "body body body body ";

            Post post = new Post();
            post.body = body;
            post.userId = userId;
            #endregion


            #region acts
            PostsUserRequest postsUserRequest = new PostsUserRequest();
            postsUserRequest.SetJsonBody(post);
            IRestResponse<dynamic> response = postsUserRequest.ExecuteRequest();

            #endregion

            #region Asserts
            Assert.Multiple(() =>
            {
                Assert.AreEqual(expectedStatusCode, response.StatusCode.ToString());
                //Etc
            });

            #endregion
        }
    }
}

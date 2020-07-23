using AutomationPracticeAPI.Helpers;
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace AutomationPracticeAPI.DBSteps
{
    class __ExemploDBSteps
    {
        public static IEnumerable __ExemploRetornaClientesEConveniosDB(string codigoConvenio)
        {
            string query = File.ReadAllText(GeneralHelpers.ReturnProjectPath() + "Queries/__ExemploSelect.sql", Encoding.UTF8);
            query = query.Replace("$codigoConvenio", codigoConvenio);
            var teste = new List<string>();

            teste = DBHelpers.RetornaDadosQuery(query);

            for (int i = 0; i < teste.Count; i++)
            {
                ArrayList result = new ArrayList();
                result.Add(teste[i]);
                result.Add(teste[i + 1]);

                i++;

                yield return result;
            }
        }

        /*
        public static void InsertNewProject(int idProjeto, string nomeProjeto)
        {
            string idProjetoString = idProjeto.ToString();
            string query = File.ReadAllText(GeneralHelpers.ReturnProjectPath() + "Queries/InsertNewProject.sql", Encoding.UTF8);
            query = query.Replace("$idProjeto", idProjetoString);
            query = query.Replace("$projectName", nomeProjeto);
            query = query.Replace("$projectDescription", nomeProjeto+" description");
            DBHelpers.ExecuteQuery(query);

            ExtentReportHelpers.AddTestInfo(2, "PARAMETERS: Executa query - " + query);
        }

        public static void DeleteAllProject()
        {
            string query = File.ReadAllText(GeneralHelpers.ReturnProjectPath() + "Queries/DeleteAllProjects.sql", Encoding.UTF8);
            DBHelpers.ExecuteQuery(query);
            ExtentReportHelpers.AddTestInfo(2, "PARAMETERS: Executa query - " + query);
        }
        */
    }
}

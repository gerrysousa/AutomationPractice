//using Dapper;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AutomationPracticeAPI.Helpers
{
    public class DBHelpers
    {
       
        private static SqlConnection GetDBConnection()
        {
            string connectionString =   "Data Source="  + JsonBuilder.ReturnParameterAppSettings("DB_SERVER_URL") + ","+ JsonBuilder.ReturnParameterAppSettings("DB_PORT") + ";;" +
                                        "User ID="      + JsonBuilder.ReturnParameterAppSettings("DB_USER") + "; " +
                                        "Password="     + JsonBuilder.ReturnParameterAppSettings("DB_PASSWORD") + ";";

            SqlConnection connection = new SqlConnection(connectionString);

            return connection;
        }

        public static void ExecuteQuery(string query)
        {
            using (SqlCommand cmd = new SqlCommand(query, GetDBConnection()))
            {
                cmd.CommandTimeout = Int32.Parse(JsonBuilder.ReturnParameterAppSettings("DB_CONNECTION_TIMEOUT"));
                cmd.Connection.Open();
                cmd.ExecuteNonQuery();
                cmd.Connection.Close();
            }
        }

        public static List<string> RetornaDadosQuery(string query)
        {
            DataSet ds = new DataSet();
            List<string> lista = new List<string>();

            using (SqlCommand cmd = new SqlCommand(query, GetDBConnection()))
            {
                cmd.CommandTimeout = Int32.Parse(JsonBuilder.ReturnParameterAppSettings("DB_CONNECTION_TIMEOUT"));
                cmd.Connection.Open();

                DataTable table = new DataTable();
                table.Load(cmd.ExecuteReader());
                ds.Tables.Add(table);

                cmd.Connection.Close();
            }

            if (ds.Tables[0].Columns.Count == 0)
            {
                return null;
            }

            try
            {
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    for (int j = 0; j < ds.Tables[0].Columns.Count; j++)
                    {
                        lista.Add(ds.Tables[0].Rows[i][j].ToString());
                    }
                }
            }
            catch (Exception)
            {
                return null;
            }

            return lista;
        }       

    }
}

<!DOCTYPE html>
<%@ page import="java.util.*, com.revature.entity.*" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>History</title>
        <link href="./css/bootstrap.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">
            <hr />
            <div>
                Money-Transfer-System
            </div>
            <hr />

            <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link" href="transaction.html">Transaction</a></li>
                <li class="nav-item"><a class="nav-link" href="history">History</a></li>
            </ul>



            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>To Account</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Transaction> txns=(ArrayList<Transaction>)request.getAttribute("txns"); %>

                            <% for(Transaction txn: txns){ %>
                                <tr>
                                    <td>
                                        <%=txn.getTransactionId()%>
                                    </td>
                                    <td>
                                        <%=txn.getAccount()%>
                                    </td>
                                    <td>
                                        <%=txn.getAmount()%>
                                    </td>
                                    <td>
                                        <%=txn.getDate()%>
                                    </td>
                                    <td>
                                        <%=txn.getCreditOrDebit()%>
                                    </td>
                                </tr>
                                <% } %>
                </tbody>
            </table>

        </div>

    </body>

    </html>
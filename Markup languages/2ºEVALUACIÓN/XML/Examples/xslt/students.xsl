<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html> 
            <head>
                <style>
                    ol{
                    list-style-type:none;
                    margin-left:-40px;
                    }
                    .rollno{
                    font-size: 30px;
                    }
                    .blue{
                    color:blue;
                    }
                    .green{
                    color:green;
                    }
                    .red{
                    color:red;
                    }
                    .grey{
                    color:grey;
                    }
                </style>
            </head>
            <body>
                <h1>Students</h1>
                <xsl:for-each select="class/student">
                    <ol>
                        <li class="rollno"><xsl:value-of select="@rollno"/></li>
                        <li>First Name: <span class="blue"><xsl:value-of select="firstname"/></span></li>
                        <li>Last Name: <span class="green"><xsl:value-of select="lastname"/></span></li>
                        <li>Nick Name: <span class="red"><xsl:value-of select="nickname"/></span></li>
                        <li>Marks: <span class="grey"><xsl:value-of select="marks"/></span></li>
                    </ol>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
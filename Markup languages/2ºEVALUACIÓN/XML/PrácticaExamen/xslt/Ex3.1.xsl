<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    table,th,td{
                    border: 1px solid;
                    }
                    .top{
                    background-color:grey;
                    color:white;
                    }
                </style>
            </head>
            <body>
                <table>
                    <tr class="top">
                        <th>ARTICLE</th>
                        <th>DETAIL</th>
                        <th>PRICE</th>
                        <th>ORDER</th>
                        <th>REFERENCE</th>
                    </tr>
                    <xsl:for-each select="articles/article">
                        <tr>
                            <td><xsl:value-of select="@type"/></td>
                            <td><xsl:value-of select="detail"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="order"/></td>
                            <td><xsl:value-of select="reference"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
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
                        <th>DETAIL</th>
                        <th>PRICE(WITHOUT IVA)</th>
                        <th>PRICE(WITH IVA)</th>
                    </tr>
                    <xsl:for-each select="articles/article">
                        <tr>
                            <td><xsl:value-of select="detail"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="price"/>*1.21</td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
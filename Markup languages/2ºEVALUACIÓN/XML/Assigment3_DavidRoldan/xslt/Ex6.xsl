<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html> 
            <head>
                <style>
                    table,th,td{
                    border:1px solid;
                    }
                    table{
                    margin-bottom:1em;
                    }
                    td{
                    text-align:left;
                    }
                </style>
            </head>
            <body>
                <h2>Titles</h2>
                <ol>
                    <xsl:for-each select="bookShop/book">
                        <li><xsl:value-of select="title"/></li>
                        <xsl:for-each select="section">
                            <h2>Section <xsl:value-of select="@par"/></h2>
                            <table>
                                <tr>
                                    <th>Title</th>
                                    <th>Num Pages</th>
                                </tr>
                                <xsl:for-each select="chapter">
                                    <tr>
                                        <td><xsl:value-of select="title"/></td>
                                        <td><xsl:value-of select="npages"/></td>
                                    </tr>
                                </xsl:for-each>
                            </table>
                        </xsl:for-each>
                    </xsl:for-each>
                </ol> 
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
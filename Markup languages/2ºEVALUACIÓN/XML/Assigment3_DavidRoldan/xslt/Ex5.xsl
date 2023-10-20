<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html> 
            <head>
                <style>
                    table{
                    border-colos:white;
                    }
                    th{
                    background-color:yellow;
                    text-align:left;
                    }
                    td{
                    background-color:#00ff00;
                    }
                </style>
            </head>
            <body>
                <table>
                    <tr>
                        <th>Food Item</th>
                        <th>Carbs (g)</th>
                        <th>Fiber (g)</th>
                        <th>Fat (g)</th>
                        <th>Energy (kj)</th>
                    </tr>
                    <xsl:apply-templates select="/food_list/food_item[@type='vegetable']"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="/food_list/food_item[@type='vegetable']">
        <tr>
            <xsl:apply-templates select="name"/>
            <xsl:apply-templates select="carbs_per_serving"/>
            <xsl:apply-templates select="fiber_per_serving"/>
            <xsl:apply-templates select="fat_per_serving"/>
            <xsl:apply-templates select="kj_per_serving"/>
        </tr>
    </xsl:template>
    <xsl:template match="name">
        <td><xsl:value-of select="."/></td>
    </xsl:template>
    <xsl:template match="carbs_per_serving">
        <td><xsl:value-of select="."/></td>
    </xsl:template>
    <xsl:template match="fiber_per_serving">
        <td><xsl:value-of select="."/></td>
    </xsl:template>
    <xsl:template match="fat_per_serving">
        <td><xsl:value-of select="."/></td>
    </xsl:template>
    <xsl:template match="kj_per_serving">
        <td><xsl:value-of select="."/></td>
    </xsl:template>
</xsl:stylesheet>
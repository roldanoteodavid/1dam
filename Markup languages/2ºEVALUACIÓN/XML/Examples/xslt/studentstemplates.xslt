<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Students</h1>
                <xsl:apply-templates select="class/student"/>
            </body>    
        </html>
    </xsl:template>
    <xsl:template match="class/student">
        <xsl:apply-templates select="@rollno"/>
        <xsl:apply-templates select="firstname"/>
        <xsl:apply-templates select="lastname"/>
        <xsl:apply-templates select="nickname"/>
        <xsl:apply-templates select="marks"/>
    </xsl:template>
    <xsl:template match="@rollno">
        <span style="font-size:2em;">
            <xsl:value-of select="."/>
        </span>
        <br/>
    </xsl:template>
    <xsl:template match="firstname">
        First Name: <span style="color:blue;">
            <xsl:value-of select="."/>
        </span>
        <br/>
    </xsl:template>
    <xsl:template match="lastname">
        Last Name: <span style="color:green;">
            <xsl:value-of select="."/>
        </span>
        <br/>
    </xsl:template>
    <xsl:template match="nickname">
        Nickame: <span style="color:red;">
            <xsl:value-of select="."/>
        </span>
        <br/>
    </xsl:template>
    <xsl:template match="marks">
        Marks: <span style="color:grey;">
            <xsl:value-of select="."/>
        </span>
        <br/>
        <br/>
    </xsl:template>
</xsl:stylesheet>
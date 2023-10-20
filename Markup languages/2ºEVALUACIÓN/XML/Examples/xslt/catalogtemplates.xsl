<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html> 
      <body>
        <h2>My CD Collection</h2>
        <ol>
          <xsl:apply-templates select="catalog/cd"/>
        </ol>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="catalog/cd">
    <li>
      <xsl:apply-templates select="title"/>
      <xsl:apply-templates select="artist"/>
    </li>
  </xsl:template>
  <xsl:template match="title">
    <xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="artist">
    from <xsl:value-of select="."/>
  </xsl:template>
</xsl:stylesheet>
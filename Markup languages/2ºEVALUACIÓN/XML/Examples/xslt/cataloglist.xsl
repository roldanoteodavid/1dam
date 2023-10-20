<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html> 
      <head>
        <style>
          ol li {
          background: #fff5e5;
          color: blue;
          padding: 5px;
          margin-left: 35px;
          }
        </style>
      </head>
      <body>
        <h2>My CD Collection</h2>
        <ol>
          <xsl:for-each select="catalog/cd">
            <li><xsl:value-of select="title"/> from <xsl:value-of select="artist"/></li>
          </xsl:for-each>
        </ol>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
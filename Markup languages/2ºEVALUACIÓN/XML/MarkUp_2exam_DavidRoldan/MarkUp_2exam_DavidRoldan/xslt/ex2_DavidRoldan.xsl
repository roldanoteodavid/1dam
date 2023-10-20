<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <style>
          .red{
          color: red;
          }
          ul,li{
          list-style-type:none;
          }
          .bold{
          font-weight: bold;
          }
          .order{
          float:left;
          margin-left:3em;
          }
        </style>
      </head>
      <body>
        <xsl:for-each select="restaurant/order">
          <div class="order">
            <h2>Order <xsl:value-of select="@orderId"/></h2>
            <h3>Date <xsl:value-of select="order_date"/></h3>
            <h3>Items:</h3>
            <xsl:for-each select="items/item">
              <ul>
                <li class="bold">Name/description:</li>
                <li><xsl:value-of select="name"/><xsl:value-of select="description"/></li>
                <xsl:choose>
                  <xsl:when test="price &gt; 10">
                    <li class="red">
                      Total amount: <xsl:value-of select="price"/></li>
                  </xsl:when>
                  <xsl:otherwise>
                    <li>Total amount: <xsl:value-of select="price"/></li>
                  </xsl:otherwise>
                </xsl:choose>
              </ul>
            </xsl:for-each>
          </div>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>
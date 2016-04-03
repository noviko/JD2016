<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html"/>
  <xsl:template match="/catalog">
    <table border="1">
      <xsl:apply-templates/>
    </table>
  </xsl:template>
  <xsl:template match="/catalog/section/product">
    <tr>
      <td>
        <xsl:value-of select="@name"/>
      </td>
      <td>
        <xsl:value-of select="description"/>
      </td>
      <td>
        <xsl:value-of select="@price"/>
      </td>
    </tr>
  </xsl:template>
</xsl:stylesheet>

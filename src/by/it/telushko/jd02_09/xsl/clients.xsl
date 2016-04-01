<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/clients">
        <table border="1">
            <tr><td>Name</td><td>Vehicle</td><td>Email</td><td>Phone</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/clients/client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/clients/client/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/vehicle">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
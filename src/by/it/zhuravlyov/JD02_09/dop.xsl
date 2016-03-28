<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" />

    <xsl:template match="/cars">
        <table border="1">
            <tr>
                <td>brand</td>
                <td>fuel</td>
                <td>year</td>
                <td>mileage</td>
                <td>Transmission</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/cars/auto">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/cars/auto/brand">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/cars/auto/fuel">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/cars/auto/year">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/cars/auto/mileage">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    
<xsl:template match="/cars/auto/Transmission">
<td><xsl:apply-templates/></td>
</xsl:template>

        </xsl:stylesheet>
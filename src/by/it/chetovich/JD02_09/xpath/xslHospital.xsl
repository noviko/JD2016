<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/hospital">
        <h1 align="center"> HOSPITAL
        </h1>
    </xsl:template>

    <xsl:template match="/diagnoses">
        <table border="1">
            <tr><td>Name</td><td>Drugs</td><td>Recovery Time</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/diagnoses/diagnosis">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/diagnoses/diagnosis/nameD">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/diagnoses/diagnosis/drugs">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/diagnoses/diagnosis/recoveryTime">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/prescribings">
        <table border="1">
            <tr><td>Type</td><td>Price</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/prescribings/prescribing">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/prescribings/prescribing/type">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/prescribings/prescribing/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
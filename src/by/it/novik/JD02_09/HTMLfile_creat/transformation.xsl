<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
<xsl:template match="/flights">
    <table border="1">
        <tr><td>Name</td><td>Surname</td><td>Qualification</td><td>Experience</td></tr>
        <xsl:apply-templates/>
    </table>
    </xsl:template>
    <xsl:template match="/flights/flight/aircrew/crewman">
        <tr><xsl:apply-templates/></tr>
        </xsl:template>
    <xsl:template match="/flights/flight/aircrew/crewman/name">
        <td><xsl:apply-templates/></td>
        </xsl:template>
    <xsl:template match="/flights/flight/aircrew/crewman/surname">
        <td><xsl:apply-templates/></td>
        </xsl:template>
    <xsl:template match="/flights/flight/aircrew/crewman/qualification">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/flights/flight/aircrew/crewman/experience">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>
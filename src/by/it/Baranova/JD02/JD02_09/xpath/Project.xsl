<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/project">
        <h1>
            Project "Hotel"
        </h1>
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/project">
        <table border="1">
            <tr><td>Number</td><td>People quantity</td><td>Bed Size</td><td>Seaview</td><td>Floor</td><td>Price</td><td>air-conditioner</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/project/room">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/project/room/room_number">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/people_quantity">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/bed_size">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/seaview">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/floor">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/room/air_conditioner">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
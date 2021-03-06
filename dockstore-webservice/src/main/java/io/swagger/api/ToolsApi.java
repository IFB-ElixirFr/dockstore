/*
 *    Copyright 2016 OICR
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package io.swagger.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.dockstore.webservice.DockstoreWebserviceApplication;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.ToolsApiServiceFactory;
import io.swagger.model.Tool;
import io.swagger.model.ToolDescriptor;
import io.swagger.model.ToolDockerfile;
import io.swagger.model.ToolTests;
import io.swagger.model.ToolVersion;

@Path(DockstoreWebserviceApplication.GA4GH_API_PATH + "/tools")

@Produces({ "application/json", "text/plain" })
@io.swagger.annotations.Api(description = "the tools API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-12T21:34:41.980Z")
public class ToolsApi {
    private final ToolsApiService delegate = ToolsApiServiceFactory.getToolsApi();

    @GET
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "List all tools", notes = "This endpoint returns all tools available or a filtered subset using metadata query parameters. ", response = Tool.class, responseContainer = "List", tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "An array of Tools that match the filter.", response = Tool.class, responseContainer = "List") })
    public Response toolsGet(
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`") @QueryParam("id") String id,
            @ApiParam(value = "The image registry that contains the image.") @QueryParam("registry") String registry,
            @ApiParam(value = "The organization in the registry that published the image.") @QueryParam("organization") String organization,
            @ApiParam(value = "The name of the image.") @QueryParam("name") String name,
            @ApiParam(value = "The name of the tool.") @QueryParam("toolname") String toolname,
            @ApiParam(value = "The description of the tool.") @QueryParam("description") String description,
            @ApiParam(value = "The author of the tool (TODO a thought occurs, are we assuming that the author of the CWL and the image are the same?).") @QueryParam("author") String author,
            @ApiParam(value = "Start index of paging. Pagination results can be based on numbers or other values chosen by the registry implementor (for example, SHA values). If this exceeds the current result set return an empty set.  If not specified in the request this will start at the beginning of the results.") @QueryParam("offset") String offset,
            @ApiParam(value = "Amount of records to return in a given page.  By default it is 1000.") @QueryParam("limit") Integer limit,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsGet(id, registry, organization, name, toolname, description, author, offset, limit, securityContext);
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "List one specific tool, acts as an anchor for self references", notes = "This endpoint returns one specific tool (which has ToolVersions nested inside it)", response = Tool.class, tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "A tool.", response = Tool.class) })
    public Response toolsIdGet(
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdGet(id, securityContext);
    }

    @GET
    @Path("/{id}/versions")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "List versions of a tool", notes = "Returns all versions of the specified tool", response = ToolVersion.class, responseContainer = "List", tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "An array of tool versions", response = ToolVersion.class, responseContainer = "List") })
    public Response toolsIdVersionsGet(
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsGet(id, securityContext);
    }

    @GET
    @Path("/{id}/versions/{version-id}/dockerfile")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Get the dockerfile for the specified image.", notes = "Returns the dockerfile for the specified image.", response = ToolDockerfile.class, tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "The tool payload.", response = ToolDockerfile.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "The tool payload is not present in the service.", response = ToolDockerfile.class) })
    public Response toolsIdVersionsVersionIdDockerfileGet(
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @ApiParam(value = "An identifier of the tool version for this particular tool registry, for example `v1`", required = true) @PathParam("version-id") String versionId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsVersionIdDockerfileGet(id, versionId, securityContext);
    }

    @GET
    @Path("/{id}/versions/{version-id}")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "List one specific tool version, acts as an anchor for self references", notes = "This endpoint returns one specific tool version", response = ToolVersion.class, tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "A tool version.", response = ToolVersion.class) })
    public Response toolsIdVersionsVersionIdGet(
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @ApiParam(value = "An identifier of the tool version, scoped to this registry, for example `v1`", required = true) @PathParam("version-id") String versionId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsVersionIdGet(id, versionId, securityContext);
    }

    @GET
    @Path("/{id}/versions/{version-id}/{type}/descriptor")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Get the tool descriptor (CWL/WDL) for the specified tool.", notes = "Returns the CWL or WDL descriptor for the specified tool.", response = ToolDescriptor.class, tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "The tool descriptor.", response = ToolDescriptor.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "The tool can not be output in the specified type.", response = ToolDescriptor.class) })
    public Response toolsIdVersionsVersionIdTypeDescriptorGet(
            @ApiParam(value = "The output type of the descriptor. If not specified it is up to the underlying implementation to determine which output type to return. Plain types return the bare descriptor while the \"non-plain\" types return a descriptor wrapped with metadata", required = true, allowableValues = "CWL, WDL, plain-CWL, plain-WDL") @PathParam("type") String type,
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @ApiParam(value = "An identifier of the tool version for this particular tool registry, for example `v1`", required = true) @PathParam("version-id") String versionId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsVersionIdTypeDescriptorGet(type, id, versionId, securityContext);
    }

    @GET
    @Path("/{id}/versions/{version-id}/{type}/descriptor/{relative-path}")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Get additional tool descriptor files (CWL/WDL) relative to the main file", notes = "Returns additional CWL or WDL descriptors for the specified tool in the same or subdirectories", response = ToolDescriptor.class, tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "The tool descriptor.", response = ToolDescriptor.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "The tool can not be output in the specified type.", response = ToolDescriptor.class) })
    public Response toolsIdVersionsVersionIdTypeDescriptorRelativePathGet(
            @ApiParam(value = "The output type of the descriptor. If not specified it is up to the underlying implementation to determine which output type to return.  Plain types return the bare descriptor while the \"non-plain\" types return a descriptor wrapped with metadata", required = true, allowableValues = "CWL, WDL, plain-CWL, plain-WDL") @PathParam("type") String type,
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @ApiParam(value = "An identifier of the tool version for this particular tool registry, for example `v1`", required = true) @PathParam("version-id") String versionId,
            @ApiParam(value = "A relative path to the additional file (same directory or subdirectories), for example 'foo.cwl' would return a 'foo.cwl' from the same directory as the main descriptor", required = true) @PathParam("relative-path") String relativePath,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsVersionIdTypeDescriptorRelativePathGet(type, id, versionId, relativePath, securityContext);
    }

    @GET
    @Path("/{id}/versions/{version-id}/{type}/tests")
    @UnitOfWork
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Get an array of test JSONs suitable for use with this descriptor type.", notes = "", response = ToolTests.class, responseContainer = "List", tags = {
            "GA4GH", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "The tool test JSON response.", response = ToolTests.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 404, message = "The tool can not be output in the specified type.", response = ToolTests.class, responseContainer = "List") })
    public Response toolsIdVersionsVersionIdTypeTestsGet(
            @ApiParam(value = "The output type of the descriptor. If not specified it is up to the underlying implementation to determine which output type to return. Plain types return the bare descriptor while the \"non-plain\" types return a descriptor wrapped with metadata", required = true, allowableValues = "CWL, WDL, plain-CWL, plain-WDL") @PathParam("type") String type,
            @ApiParam(value = "A unique identifier of the tool, scoped to this registry, for example `123456`", required = true) @PathParam("id") String id,
            @ApiParam(value = "An identifier of the tool version for this particular tool registry, for example `v1`", required = true) @PathParam("version-id") String versionId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.toolsIdVersionsVersionIdTypeTestsGet(type, id, versionId, securityContext);
    }
}

<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 1}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level1id < 0}">
				<label> Level 1</label>
				<form:select path="level1Id" id="level1Id"
					cssClass="custom-select  levelSelectClass level1Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level1Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:input path="level1Id" value="${level1Id}"
					cssClass="level1Class" ></form:input>
			</c:otherwise> --%>
			<c:otherwise>
			<div style=" display: none;">
				<form:select path="level1Id" id="level1Id"
						cssClass="level1Class">
						<form:options items="${level1Map}" />
					</form:select>
			</div>
			<%-- 	<form:hidden path="level1Id" value="${level1Id}"
					 cssClass="level1Class"></form:hidden> --%>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 2}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level2id < 0}">
				<label> Level 2</label>
				<form:select path="level2Id" id="level2Id"
					cssClass="custom-select  levelSelectClass level2Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level2Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level2Id" value="${level2Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 2</label>
					</label>
					<form:select path="level2Id" id="level2Id"
						cssClass="level2Class">
						<form:options items="${level2Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 3}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level3id < 0}">
				<label> Level 3</label>
				<form:select path="level3Id" id="level3Id"
					cssClass="custom-select  levelSelectClass  level3Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level3Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level3Id" value="${level3Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label>  Level 3</label>
					</label>
					<form:select path="level3Id" id="level3Id"
						cssClass="level3Class">
						<form:options items="${level3Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 4}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level4id < 0}">
				<label> Level 4</label>
				<form:select path="level4Id" id="level4Id"
					cssClass="custom-select  levelSelectClass level4Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level4Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level4Id" value="${level4Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 4</label>
					</label>
					<form:select path="level4Id" id="level4Id"
						cssClass="level4Class">
						<form:options items="${level4Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 5}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level5id < 0}">
				<label> Level 5</label>
				<form:select path="level5Id" id="level5Id"
					cssClass="custom-select  levelSelectClass level5Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level5Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level5Id" value="${level5Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 5</label>
					</label>
					<form:select path="level5Id" id="level5Id"
						cssClass="level5Class">
						<form:options items="${level5Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	</div>
&nbsp;

<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 6}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level6id < 0}">
				<label> Level 6</label>
				<form:select path="level6Id" id="level6Id"
					cssClass="custom-select  levelSelectClass level6Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level6Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level6Id" value="${level6Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 6</label>
					</label>
					<form:select path="level6Id" id="level6Id"
						cssClass="level6Class">
						<form:options items="${level6Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 7}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level7id < 0}">
				<label> Level 7</label>
				<form:select path="level7Id" id="level7Id"
					cssClass="custom-select  levelSelectClass level7Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level7Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level7Id" value="${level7Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 7</label>
					</label>
					<form:select path="level7Id" id="level7Id"
						cssClass="level7Class">
						<form:options items="${level7Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 8}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level8id < 0}">
				<label> Level 8</label>
				<form:select path="level8Id" id="level8Id"
					cssClass="custom-select  levelSelectClass level8Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level8Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level8Id" value="${level8Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 8</label>
					</label>
					<form:select path="level8Id" id="level8Id"
						cssClass="level8Class">
						<form:options items="${level8Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 9}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level9id < 0}">
				<label> Level 9</label>
				<form:select path="level9Id" id="level9Id"
					cssClass="custom-select  levelSelectClass level9Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level9Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level9Id" value="${level9Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 9</label>
					</label>
					<form:select path="level9Id" id="level9Id"
						cssClass="level9Class">
						<form:options items="${level9Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 10}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level10id < 0}">
				<label> Level 10</label>
				<form:select path="level10Id" id="level10Id"
					cssClass="custom-select  levelSelectClass level10Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level10Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level10Id" value="${level10Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 10</label>
					</label>
					<form:select path="level10Id" id="level10Id"
						cssClass="level10Class">
						<form:options items="${level10Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 11}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level11id < 0}">
				<label> Level 11</label>
				<form:select path="level11Id" id="level11Id"
					cssClass="custom-select  levelSelectClass level11Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level11Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level11Id" value="${level11Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 11</label>
					</label>
					<form:select path="level11Id" id="level11Id"
						cssClass="level11Class">
						<form:options items="${level11Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 12}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level12id < 0}">
				<label> Level 12</label>
				<form:select path="level12Id" id="level12Id"
					cssClass="custom-select  levelSelectClass level12Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level12Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level12d" value="${level12Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 12</label>
					</label>
					<form:select path="level12Id" id="level12Id"
						cssClass="level12Class">
						<form:options items="${level12Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 13}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level13id < 0}">
				<label> Level 13</label>
				<form:select path="level13Id" id="level13Id"
					cssClass="custom-select  levelSelectClass level13Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level13Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level13d" value="${level13Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 13</label>
					</label>
					<form:select path="level13Id" id="level13Id"
						cssClass="level13Class">
						<form:options items="${level13Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 14}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level14id < 0}">
				<label> Level 14</label>
				<form:select path="level14Id" id="level14Id"
					cssClass="custom-select  levelSelectClass level14Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level14Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level14d" value="${level14Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 14</label>
					</label>
					<form:select path="level14Id" id="level14Id"
						cssClass="level14Class">
						<form:options items="${level14Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>
&nbsp;
<div class="form-group">
	<c:if
		test="${sessionObj.applicationMasterObj.orghierarchylevel >= 15}">
		<c:choose>
			<c:when
				test="${sessionObj.levelIndexMasterObj.id.level15id < 0}">
				<label> Level 15</label>
				<form:select path="level15Id" id="level15Id"
					cssClass="custom-select  levelSelectClass level15Class">
					<form:option key="-1" value="-1" label="SELECT" />
					<form:options items="${level15Map}" />
				</form:select>
			</c:when>
			<%-- <c:otherwise>
				<form:hidden path="level15d" value="${level15Id}"
					 ></form:hidden>
			</c:otherwise> --%>
			<c:otherwise>
				<div style=" display: none;">
					<label> Level 15</label>
					</label>
					<form:select path="level15Id" id="level15Id"
						cssClass="level15Class">
						<form:options items="${level15Map}" />
					</form:select>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>

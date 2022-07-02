<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="微信id" prop="wechatId">
        <el-input
          v-model="queryParams.wechatId"
          placeholder="请输入微信id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信手机号" prop="wechatPhone">
        <el-input
          v-model="queryParams.wechatPhone"
          placeholder="请输入微信手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="昵称" prop="alias">
        <el-input
          v-model="queryParams.alias"
          placeholder="请输入昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期" prop="birthDate">
        <el-date-picker clearable
          v-model="queryParams.birthDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入体重"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input
          v-model="queryParams.height"
          placeholder="请输入身高"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="月收入" prop="income">
        <el-select v-model="queryParams.income" placeholder="请选择月收入" clearable>
          <el-option
            v-for="dict in dict.type.xq_income"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-select v-model="queryParams.education" placeholder="请选择学历" clearable>
          <el-option
            v-for="dict in dict.type.xq_education"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="故乡字符" prop="hometownStr">
        <el-input
          v-model="queryParams.hometownStr"
          placeholder="请输入故乡字符"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作地字符" prop="workplaceStr">
        <el-input
          v-model="queryParams.workplaceStr"
          placeholder="请输入工作地字符"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="婚姻状况" prop="marriage">
        <el-select v-model="queryParams.marriage" placeholder="请选择婚姻状况" clearable>
          <el-option
            v-for="dict in dict.type.xq_marriage"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="职业" prop="occupation">
        <el-input
          v-model="queryParams.occupation"
          placeholder="请输入职业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="买车情况" prop="car">
        <el-select v-model="queryParams.car" placeholder="请选择买车情况" clearable>
          <el-option
            v-for="dict in dict.type.xq_car"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="买房情况" prop="house">
        <el-select v-model="queryParams.house" placeholder="请选择买房情况" clearable>
          <el-option
            v-for="dict in dict.type.xq_house"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="微信号" prop="wechat">
        <el-input
          v-model="queryParams.wechat"
          placeholder="请输入微信号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宗教信仰" prop="religion">
        <el-select v-model="queryParams.religion" placeholder="请选择宗教信仰" clearable>
          <el-option
            v-for="dict in dict.type.xq_religion"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="身份证号" prop="idCard">
        <el-input
          v-model="queryParams.idCard"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否实名认证" prop="isAutonym">
        <el-select v-model="queryParams.isAutonym" placeholder="请选择是否实名认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否学历认证" prop="isEducation">
        <el-select v-model="queryParams.isEducation" placeholder="请选择是否学历认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否婚况认证" prop="isMarriage">
        <el-select v-model="queryParams.isMarriage" placeholder="请选择是否婚况认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否车辆认证" prop="isCar">
        <el-select v-model="queryParams.isCar" placeholder="请选择是否车辆认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否房产认证" prop="isHouse">
        <el-select v-model="queryParams.isHouse" placeholder="请选择是否房产认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否工作认证" prop="isWork">
        <el-select v-model="queryParams.isWork" placeholder="请选择是否工作认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否收入认证" prop="isIncome">
        <el-select v-model="queryParams.isIncome" placeholder="请选择是否收入认证" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否删除" prop="isDelete">
        <el-select v-model="queryParams.isDelete" placeholder="请选择是否删除" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-select v-model="queryParams.state" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.xq_member_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否隐身" prop="isConceal">
        <el-select v-model="queryParams.isConceal" placeholder="请选择是否隐身" clearable>
          <el-option
            v-for="dict in dict.type.xq_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['member:member:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['member:member:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['member:member:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['member:member:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="微信id" align="center" prop="wechatId" />
      <el-table-column label="微信手机号" align="center" prop="wechatPhone" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="昵称" align="center" prop="alias" />
      <el-table-column label="性别,0=男、1=女" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="出生日期" align="center" prop="birthDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="体重" align="center" prop="weight" />
      <el-table-column label="身高" align="center" prop="height" />
      <el-table-column label="月收入" align="center" prop="income">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_income" :value="scope.row.income"/>
        </template>
      </el-table-column>
      <el-table-column label="学历" align="center" prop="education">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_education" :value="scope.row.education"/>
        </template>
      </el-table-column>
      <el-table-column label="故乡字符" align="center" prop="hometownStr" />
      <el-table-column label="工作地字符" align="center" prop="workplaceStr" />
      <el-table-column label="婚姻状况" align="center" prop="marriage">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_marriage" :value="scope.row.marriage"/>
        </template>
      </el-table-column>
      <el-table-column label="职业" align="center" prop="occupation" />
      <el-table-column label="买车情况" align="center" prop="car">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_car" :value="scope.row.car"/>
        </template>
      </el-table-column>
      <el-table-column label="买房情况" align="center" prop="house">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_house" :value="scope.row.house"/>
        </template>
      </el-table-column>
      <el-table-column label="微信号" align="center" prop="wechat" />
      <el-table-column label="手机号码" align="center" prop="phone" />
      <el-table-column label="宗教信仰" align="center" prop="religion">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_religion" :value="scope.row.religion"/>
        </template>
      </el-table-column>
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="是否实名认证" align="center" prop="isAutonym">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isAutonym"/>
        </template>
      </el-table-column>
      <el-table-column label="是否学历认证" align="center" prop="isEducation">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isEducation"/>
        </template>
      </el-table-column>
      <el-table-column label="是否婚况认证" align="center" prop="isMarriage">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isMarriage"/>
        </template>
      </el-table-column>
      <el-table-column label="是否车辆认证" align="center" prop="isCar">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isCar"/>
        </template>
      </el-table-column>
      <el-table-column label="是否房产认证" align="center" prop="isHouse">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isHouse"/>
        </template>
      </el-table-column>
      <el-table-column label="是否工作认证" align="center" prop="isWork">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isWork"/>
        </template>
      </el-table-column>
      <el-table-column label="是否收入认证" align="center" prop="isIncome">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isIncome"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间" align="center" prop="lastdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否删除" align="center" prop="isDelete">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isDelete"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_member_state" :value="scope.row.state"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="是否隐身" align="center" prop="isConceal">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.xq_yes_no" :value="scope.row.isConceal"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['member:member:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['member:member:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改会员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="微信id" prop="wechatId">
          <el-input v-model="form.wechatId" placeholder="请输入微信id" />
        </el-form-item>
        <el-form-item label="微信手机号" prop="wechatPhone">
          <el-input v-model="form.wechatPhone" placeholder="请输入微信手机号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="昵称" prop="alias">
          <el-input v-model="form.alias" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="性别字符" prop="sexStr">
          <el-input v-model="form.sexStr" placeholder="请输入性别字符" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthDate">
          <el-date-picker clearable
            v-model="form.birthDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入体重" />
        </el-form-item>
        <el-form-item label="身高" prop="height">
          <el-input v-model="form.height" placeholder="请输入身高" />
        </el-form-item>
        <el-form-item label="月收入字符" prop="incomeStr">
          <el-input v-model="form.incomeStr" placeholder="请输入月收入字符" />
        </el-form-item>
        <el-form-item label="月收入" prop="income">
          <el-select v-model="form.income" placeholder="请选择月收入">
            <el-option
              v-for="dict in dict.type.xq_income"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学历字符" prop="educationStr">
          <el-input v-model="form.educationStr" placeholder="请输入学历字符" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-select v-model="form.education" placeholder="请选择学历">
            <el-option
              v-for="dict in dict.type.xq_education"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="故乡字符" prop="hometownStr">
          <el-input v-model="form.hometownStr" placeholder="请输入故乡字符" />
        </el-form-item>
        <el-form-item label="故乡" prop="hometown">
          <el-input v-model="form.hometown" placeholder="请输入故乡" />
        </el-form-item>
        <el-form-item label="工作地字符" prop="workplaceStr">
          <el-input v-model="form.workplaceStr" placeholder="请输入工作地字符" />
        </el-form-item>
        <el-form-item label="工作地" prop="workplace">
          <el-input v-model="form.workplace" placeholder="请输入工作地" />
        </el-form-item>
        <el-form-item label="婚姻状况字符" prop="marriageStr">
          <el-input v-model="form.marriageStr" placeholder="请输入婚姻状况字符" />
        </el-form-item>
        <el-form-item label="婚姻状况" prop="marriage">
          <el-select v-model="form.marriage" placeholder="请选择婚姻状况">
            <el-option
              v-for="dict in dict.type.xq_marriage"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否有小孩" prop="isKid">
          <el-select v-model="form.isKid" placeholder="请选择是否有小孩">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职业" prop="occupation">
          <el-input v-model="form.occupation" placeholder="请输入职业" />
        </el-form-item>
        <el-form-item label="是否要小孩" prop="isDemandKid">
          <el-select v-model="form.isDemandKid" placeholder="请选择是否要小孩">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="买车情况字符" prop="carStr">
          <el-input v-model="form.carStr" placeholder="请输入买车情况字符" />
        </el-form-item>
        <el-form-item label="买车情况" prop="car">
          <el-select v-model="form.car" placeholder="请选择买车情况">
            <el-option
              v-for="dict in dict.type.xq_car"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="买房情况字符" prop="houseStr">
          <el-input v-model="form.houseStr" placeholder="请输入买房情况字符" />
        </el-form-item>
        <el-form-item label="买房情况" prop="house">
          <el-select v-model="form.house" placeholder="请选择买房情况">
            <el-option
              v-for="dict in dict.type.xq_house"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="微信号" prop="wechat">
          <el-input v-model="form.wechat" placeholder="请输入微信号" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="宗教信仰字符" prop="religionStr">
          <el-input v-model="form.religionStr" placeholder="请输入宗教信仰字符" />
        </el-form-item>
        <el-form-item label="宗教信仰" prop="religion">
          <el-select v-model="form.religion" placeholder="请选择宗教信仰">
            <el-option
              v-for="dict in dict.type.xq_religion"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否抽烟" prop="isSmoking">
          <el-select v-model="form.isSmoking" placeholder="请选择是否抽烟">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否喝酒" prop="isDrink">
          <el-select v-model="form.isDrink" placeholder="请选择是否喝酒">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="头像url">
          <image-upload v-model="headPortraitUrl_"/>
        </el-form-item>
        <el-form-item label="相册json">
          <image-upload v-model="pictureJson_"/>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="是否实名认证" prop="isAutonym">
          <el-select v-model="form.isAutonym" placeholder="请选择是否实名认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否学历认证" prop="isEducation">
          <el-select v-model="form.isEducation" placeholder="请选择是否学历认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否婚况认证" prop="isMarriage">
          <el-select v-model="form.isMarriage" placeholder="请选择是否婚况认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否车辆认证" prop="isCar">
          <el-select v-model="form.isCar" placeholder="请选择是否车辆认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否房产认证" prop="isHouse">
          <el-select v-model="form.isHouse" placeholder="请选择是否房产认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否工作认证" prop="isWork">
          <el-select v-model="form.isWork" placeholder="请选择是否工作认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否收入认证" prop="isIncome">
          <el-select v-model="form.isIncome" placeholder="请选择是否收入认证">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="自我描述" prop="selfDescription">
          <el-input v-model="form.selfDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="兴趣爱好" prop="interest">
          <el-input v-model="form.interest" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="择偶标准描述" prop="mateCriterionDescription">
          <el-input v-model="form.mateCriterionDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="家庭背景" prop="familyBackground">
          <el-input v-model="form.familyBackground" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDelete">
          <el-select v-model="form.isDelete" placeholder="请选择是否删除">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-select v-model="form.state" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.xq_member_state"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否隐身" prop="isConceal">
          <el-select v-model="form.isConceal" placeholder="请选择是否隐身">
            <el-option
              v-for="dict in dict.type.xq_yes_no"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMember, getMember, delMember, addMember, updateMember } from "@/api/blinddate/xq_member/member";
//D:\jiandian\jiandian_admin_2\jiandian_admin_2\ruoyi-ui\src\views\
// blinddate/xq_member/index
export default {
  name: "Member",
  dicts: ['xq_education', 'xq_house', 'xq_car', 'xq_member_state', 'xq_marriage', 'sys_user_sex', 'xq_yes_no', 'xq_income', 'xq_religion'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 会员表格数据
      memberList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        wechatId: null,
        wechatPhone: null,
        name: null,
        alias: null,
        sex: null,
        birthDate: null,
        age: null,
        weight: null,
        height: null,
        income: null,
        education: null,
        hometownStr: null,
        workplaceStr: null,
        marriage: null,
        occupation: null,
        car: null,
        house: null,
        wechat: null,
        phone: null,
        religion: null,
        idCard: null,
        isAutonym: null,
        isEducation: null,
        isMarriage: null,
        isCar: null,
        isHouse: null,
        isWork: null,
        isIncome: null,
        isDelete: null,
        state: null,
        isConceal: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        alias: [
          { required: true, message: "昵称不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        birthDate: [
          { required: true, message: "出生日期不能为空", trigger: "blur" }
        ],
        age: [
          { required: true, message: "年龄不能为空", trigger: "blur" }
        ],
        weight: [
          { required: true, message: "体重不能为空", trigger: "blur" }
        ],
        height: [
          { required: true, message: "身高不能为空", trigger: "blur" }
        ],
        income: [
          { required: true, message: "月收入不能为空", trigger: "change" }
        ],
        education: [
          { required: true, message: "学历不能为空", trigger: "change" }
        ],
        hometownStr: [
          { required: true, message: "故乡字符不能为空", trigger: "blur" }
        ],
        workplaceStr: [
          { required: true, message: "工作地字符不能为空", trigger: "blur" }
        ],
        marriage: [
          { required: true, message: "婚姻状况不能为空", trigger: "change" }
        ],
        occupation: [
          { required: true, message: "职业不能为空", trigger: "blur" }
        ],
        car: [
          { required: true, message: "买车情况不能为空", trigger: "change" }
        ],
        house: [
          { required: true, message: "买房情况不能为空", trigger: "change" }
        ],
        phone: [
          { required: true, message: "手机号码不能为空", trigger: "blur" }
        ],
        religion: [
          { required: true, message: "宗教信仰不能为空", trigger: "change" }
        ],
        headPortraitUrl: [
          { required: true, message: "头像url不能为空", trigger: "blur" }
        ],
        pictureJson: [
          { required: true, message: "相册json不能为空", trigger: "blur" }
        ],
        selfDescription: [
          { required: true, message: "自我描述不能为空", trigger: "blur" }
        ],
      },
      headPortraitUrl_:[],
      pictureJson_: []
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询会员列表 */
    getList() {
      this.loading = true;
      listMember(this.queryParams).then(response => {
        this.memberList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        wechatId: null,
        wechatPhone: null,
        name: null,
        alias: null,
        sexStr: null,
        sex: null,
        birthDate: null,
        age: null,
        weight: null,
        height: null,
        incomeStr: null,
        income: null,
        educationStr: null,
        education: null,
        hometownStr: null,
        hometown: null,
        workplaceStr: null,
        workplace: null,
        marriageStr: null,
        marriage: null,
        isKid: null,
        occupation: null,
        isDemandKid: null,
        carStr: null,
        car: null,
        houseStr: null,
        house: null,
        wechat: null,
        phone: null,
        religionStr: null,
        religion: null,
        isSmoking: null,
        isDrink: null,
        headPortraitUrl: null,
        pictureJson: null,
        idCard: null,
        isAutonym: null,
        isEducation: null,
        isMarriage: null,
        isCar: null,
        isHouse: null,
        isWork: null,
        isIncome: null,
        selfDescription: null,
        interest: null,
        mateCriterionDescription: null,
        familyBackground: null,
        createdate: null,
        lastdate: null,
        isDelete: null,
        state: null,
        remark: null,
        isConceal: null
      };
      this.resetForm("form");
      this.headPortraitUrl_ = [];
      this.pictureJson_ = [];
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加会员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员";
        if(!!this.form.headPortraitUrl){
          this.headPortraitUrl_ = JSON.parse(this.form.headPortraitUrl);
        }
        if(!!this.form.pictureJson){
          this.pictureJson_ = JSON.parse(this.form.pictureJson);
        }
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {

          this.form.headPortraitUrl = JSON.stringify(this.headPortraitUrl_)
          this.form.pictureJson = JSON.stringify(this.pictureJson_)

          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMember(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除会员编号为"' + ids + '"的数据项？').then(function() {
        return delMember(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('member/member/export', {
        ...this.queryParams
      }, `member_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

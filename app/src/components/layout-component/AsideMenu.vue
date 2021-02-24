<template>
    <div class="AsideMenu bg-navy"
         :class="asideMenuClass"
    >
        <el-menu
                mode="vertical"
                :unique-opened="true"
                class="w100p trans"
                :background-color="$_colors.navy"
                :text-color="$_colors.silver"
                :active-text-color="$_colors.aqua"
                :collapse="!$store.state.asideIsExpend"
        >
            <template v-for="( item) in menu">
                <el-submenu :index="item.url" v-if="hasChild(item) && needShow(item)"
                    :key="item.url"
                >
                    <template slot="title">
                        <i :class="item.icon"></i>
                        <span slot="title">{{item.name}}</span>
                    </template>
                    <el-menu-item
                            v-for="child in item.children"
                            :key="child.id"
                            :index="child.url"
                            @click.native="clickLink(child)"
                    >
                        <i class="iconfont" :class="child.icon"></i>
                        <span slot="title">{{ child.name }}</span>
                    </el-menu-item>
                </el-submenu>
                <el-menu-item :index="item.url" v-if="!hasChild(item) && needShow(item)"
                              :key="item.url"
                              @click.native="clickLink(item)"
                >
                    <i :class="item.icon"></i>
                    <span slot="title">{{ item.name}}</span>
                </el-menu-item>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import aside_menu from "@/router/aside_menu";
    import Windows from "@/project/var/Windows";
    import Api from "@/assets/api/Api";
    import UserHandle from "@/project/user/UserHandle";

    export default {
        name: "AsideMenu",
        components: {},
        props: {},
        data() {
            return {
                menu: null,
            }
        },
        mounted() {
            this.reload();
        },
        activated() {
        },
        methods: {
            reload() {
                this.$ajax.request(Api.menu.menuList, {
                    roleId: UserHandle.getLoginUser().roleId
                })
                    .then(resp => {
                        this.menu = resp;
                    })
            },
            hasChild(route) {
                return route.children && route.children.length > 0;
            },
            needShow(route) {
                //return !route.meta.hidden
                return true;
            },
            clickLink(router) {
                Windows.set(router);
            }
        },
        watch: {},
        computed: {
            asideMenuClass() {
                return {
                    'open': this.$store.state.asideIsExpend,
                }
            }
        },
    }
</script>

<style lang="less" scoped>
    @import (reference) "~@/style/all.less";

    .AsideMenu {

        .iconfont {
            padding-right: 8px;
        }
    }
</style>
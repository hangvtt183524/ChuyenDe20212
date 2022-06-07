<script>
import AppHeader from './AppHeader';
import AppFooter from './AppFooter';

export default {
    name: 'AppLayout',
    components: {
        AppHeader,
        AppFooter,
    }
}
</script>

<template>
    <div class="d-flex flex-column flex-fluid">
        <AppHeader />
        <slot>App Content</slot>
        <AppFooter />
    </div>
</template>

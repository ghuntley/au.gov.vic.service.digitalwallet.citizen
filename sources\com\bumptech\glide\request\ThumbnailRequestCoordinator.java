package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private Request full;
    private boolean isRunning;
    private final RequestCoordinator parent;
    private Request thumb;

    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.parent = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        return parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        return parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        return parentCanNotifyCleared() && request.equals(this.full);
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        if (!request.equals(this.thumb)) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
            if (!this.thumb.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        RequestCoordinator requestCoordinator;
        if (request.equals(this.full) && (requestCoordinator = this.parent) != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        this.isRunning = true;
        if (!this.full.isComplete() && !this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.isRunning && !this.full.isRunning()) {
            this.full.begin();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.full.clear();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        return this.full.isRunning();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        return this.full.isCleared();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        return this.full.isFailed();
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        Request request2 = this.full;
        if (request2 == null) {
            if (thumbnailRequestCoordinator.full != null) {
                return false;
            }
        } else if (!request2.isEquivalentTo(thumbnailRequestCoordinator.full)) {
            return false;
        }
        Request request3 = this.thumb;
        Request request4 = thumbnailRequestCoordinator.thumb;
        if (request3 == null) {
            if (request4 == null) {
                return true;
            }
            return false;
        } else if (!request3.isEquivalentTo(request4)) {
            return false;
        }
        return true;
    }
}

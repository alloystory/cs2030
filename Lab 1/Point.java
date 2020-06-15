class Point {
    private double _xcoor;
    private double _ycoor;

    public Point(double x, double y) {
        this._xcoor = x;
        this._ycoor = y;
    }

    private double getXCoor() {
        return this._xcoor;
    }

    private double getYCoor() {
        return this._ycoor;
    }
    
    protected Point midPoint(Point q) {
        double midX = (q.getXCoor() + this._xcoor) / 2;
        double midY = (q.getYCoor() + this._ycoor) / 2;
        Point midPoint = new Point(midX, midY);
        return midPoint;
    }

    protected double angleTo(Point q) {
        double xDist = (q.getXCoor() - this._xcoor);
        double yDist = (q.getYCoor() - this._ycoor);
        double angle = Math.atan2(yDist, xDist);
        return angle;
    }

    protected Point findCentre(Point q) {
        Point midPoint = this.midPoint(q);
        double angle = this.angleTo(q);
        double length = this.distTo(q);
        if (length < 2) {
            double lenMidPt = length / 2;
            double dist = Math.sqrt(1 - (lenMidPt * lenMidPt));
            double centreX = midPoint.getXCoor() + dist * Math.cos(angle + Math.PI / 2);
            double centreY = midPoint.getYCoor() + dist * Math.sin(angle + Math.PI / 2);
            Point centre = new Point(centreX, centreY);
            return centre;
        } else {
            return null;
        }
    }

    protected double distTo(Point q) {
        double xDiff = q._xcoor - this._xcoor;
        double yDiff = q._ycoor - this._ycoor;
        double length = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
        return length;
    }

    @Override
    public String toString() {
        return "(" + String.format("%.3f", getXCoor()) + ", " + String.format("%.3f", getYCoor()) + ")";
    }
}
